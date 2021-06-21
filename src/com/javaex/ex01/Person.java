package com.javaex.ex01;


public class Person {
	private String name;
	private String hp;
	private String com;
	
	public Person() {
		
	}
	
	public Person(String name,String hp, String com) {
		this.name=name;
		this.hp=hp;
		this.com=com;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", hp=" + hp + ", com=" + com + "]";
	}
	
	public String save() {
		return name+","+hp+","+com;
	}
}
