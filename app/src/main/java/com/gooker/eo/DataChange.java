package com.gooker.eo;

/**
 * Created by mz on 15/8/17.
 */
public class DataChange {

	private String name;
	private String age;

	public DataChange() {
	}

	public DataChange(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "DataChange{" +
				"name='" + name + '\'' +
				", age='" + age + '\'' +
				'}';
	}
}
