package br.com.ufc.web.purchaselist.model.model;

public class HelloWorld {
	
	private String message;
	private String git;
	
	public HelloWorld() {
		super();
	}

	public HelloWorld(String message, String git) {
		super();
		this.message = message;
		this.git = git;
	}

	public String getMessage() {
		return message;
	}

	public String getGit() {
		return git;
	}

	@Override
	public String toString() {
		return "HelloWorld [message=" + message + ", GIT=" + git + "]";
	}
	
}
