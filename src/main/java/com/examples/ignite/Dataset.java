package com.examples.ignite;

import java.io.Serializable;

/**
 * @author pavel.arakelyan on 7/11/17.
 */
public class Dataset implements Serializable{
	private Integer a;
	private String b;

	public Dataset(Integer a, String b) {
		this.a = a;
		this.b = b;
	}

	public Integer getA() {
		return a;
	}

	public String getB() {
		return b;
	}

	@Override
	public String toString() {
		return "Dataset{" +
				"a=" + a +
				", b='" + b + '\'' +
				'}';
	}
}
