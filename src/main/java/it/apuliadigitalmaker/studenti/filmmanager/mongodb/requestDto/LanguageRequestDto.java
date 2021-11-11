package it.apuliadigitalmaker.studenti.filmmanager.mongodb.requestDto;

public class LanguageRequestDto {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LanguageRequestDto [name=" + name + "]";
	}

	public LanguageRequestDto() {
		super();
	}

	public LanguageRequestDto(String name) {
		super();
		this.name = name;
	}
}
