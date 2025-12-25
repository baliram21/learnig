package org.nayan.exception;


public class FinallyCleanup {
    public static void use() {
        Connection con = null;
        try {
            con = new Connection();
            con.execute();
        } finally {
            if (con != null) {
                try { con.close(); } catch (Exception e) { /* log */ }
            }
        }
    }
}
