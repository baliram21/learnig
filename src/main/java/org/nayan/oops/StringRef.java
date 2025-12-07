package org.nayan.oops;

public class StringRef {
	public static void main(String[] args) {
		String s1 = "abc";      // s1 points to string literal "abc"
		String s2 = "def";      // s2 points to string literal "def"
		String s3 = s2;         // s3 now points to same object as s2, i.e., "def"

		s2 = "ghi";             // s2 is reassigned to a new string literal "ghi"
		// s3 still points to "def", since strings are immutable and s3 was not changed

		System.out.println(s1 + s2 + s3);
		// Output: "abcghidef"
		// Explanation: s1 = "abc", s2 = "ghi", s3 = "def"
		// So the concatenated string is "abc" + "ghi" + "def" => "abcghidef"
	}
}
