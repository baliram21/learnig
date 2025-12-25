package org.nayan.design_pattern.solid;

/*
 * Class: OrderPaymentExample
 *
 * Below are ONLY comments that explain each SOLID principle as it relates to a single class
 * that coordinates payment for an order. The comments are intentionally placed near the
 * relevant code elements so you can see the mapping between principle and implementation.
 *
 * NOTE: This class is a small coordinator (example) — real implementations would live in
 * separate files. All explanatory text required by your request appears only in comments.
 */

import java.util.Map;
import java.util.Objects;

public class OrderPaymentExample {

    /* 
     * SRP — Single Responsibility Principle
     *
     * This class's single responsibility is "orchestrating payment for an order".
     * It does NOT: perform gateway API calls, persist data, send emails, or log details.
     * Those responsibilities belong to other classes (e.g., PaymentProcessor, Repository, EmailService).
     *
     * Keeping this class focused on orchestration means there is only one reason for it to change:
     * changes to how we choose or coordinate processors — not changes to how payments are processed.
     */
    private final Map<String, PaymentProcessor> registry; // injected dependency (abstraction)

    /*
     * DIP — Dependency Inversion Principle
     *
     * This high-level module depends on the abstraction (PaymentProcessor) rather than concrete classes.
     * The registry is a map of abstractions provided to the constructor (inversion of control).
     * That allows wiring different concrete implementations (Stripe, PayPal, etc.) without changing this class.
     */
    public OrderPaymentExample(Map<String, PaymentProcessor> registry) {
        this.registry = Objects.requireNonNull(registry);
    }

    /*
     * OCP — Open/Closed Principle
     *
     * The class is closed for modification but open for extension:
     * - To add a new payment provider, implement PaymentProcessor and register it in the registry.
     * - No changes are required inside this class to support a new provider.
     *
     * This method therefore delegates to the abstraction and remains unchanged as new providers are added.
     */
    public PaymentResult processOrderPayment(String orderId, Money amount, String providerKey) {
        PaymentProcessor processor = registry.get(providerKey);
        if (processor == null) {
            return PaymentResult.failure("unsupported provider: " + providerKey);
        }

        // Delegate actual processing to the PaymentProcessor abstraction.
        return processor.process(new PaymentRequest(orderId, amount));
    }

    /*
     * LSP — Liskov Substitution Principle
     *
     * Any implementation of PaymentProcessor must be substitutable for the interface without
     * surprising this class. That means:
     * - Implementations must honor the contract (e.g., return a PaymentResult, not throw unchecked exceptions for normal flow).
     * - This class assumes it can call process(...) and trust the contract; if a subclass breaks it,
     *   substitutability is violated and client code (this class) would break.
     *
     * Designing implementations to follow the interface contract ensures LSP is preserved.
     */

    /*
     * ISP — Interface Segregation Principle
     *
     * PaymentProcessor is intentionally small (one method: process). Clients depend only on this narrow interface.
     * If a provider had extra capabilities (refund, tokenize), those should be in separate interfaces:
     * e.g., RefundableProcessor, TokenizableProcessor — so clients that only need process(...) are not forced to implement/know unrelated methods.
     *
     * This keeps implementers and clients decoupled from unneeded functionality.
     */

    // --- Supporting lightweight types used above (kept inner for brevity) ---

    /**
     * Narrow interface — follows ISP. Clients needing only payment processing depend on this.
     */
    public interface PaymentProcessor {
        PaymentResult process(PaymentRequest request);
    }

    /**
     * Small value object representing a payment request.
     * In a real codebase this would be immutable and in its own file.
     */
    public static final class PaymentRequest {
        private final String orderId;
        private final Money amount;

        public PaymentRequest(String orderId, Money amount) {
            this.orderId = orderId;
            this.amount = amount;
        }

        public String orderId() { return orderId; }
        public Money amount() { return amount; }
    }

    /**
     * Simple result wrapper used as a stable contract returned by PaymentProcessor.
     * Keeping a small, well-defined result helps maintain LSP (implementations return expected result shape).
     */
    public static final class PaymentResult {
        private final boolean success;
        private final String message;

        private PaymentResult(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public static PaymentResult success(String m) { return new PaymentResult(true, m); }
        public static PaymentResult failure(String m) { return new PaymentResult(false, m); }

        public boolean isSuccess() { return success; }
        public String getMessage() { return message; }
    }

    /**
     * Minimal Money value type placeholder (would normally include currency, arithmetic, immutability).
     */
    public static final class Money {
        private final long cents;
        private final String currency;

        public Money(long cents, String currency) {
            this.cents = cents;
            this.currency = currency;
        }

        public long cents() { return cents; }
        public String currency() { return currency; }
    }
}
