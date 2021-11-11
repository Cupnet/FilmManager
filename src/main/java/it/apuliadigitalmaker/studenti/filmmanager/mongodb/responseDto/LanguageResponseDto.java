package it.apuliadigitalmaker.studenti.filmmanager.mongodb.responseDto;



public class LanguageResponseDto {
	
	private String name;
	
	private Long id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LanguageResponseDto() {
		super();
	}

	public LanguageResponseDto(String name, Long id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "LanguageResponseDto [name=" + name + ", id=" + id + "]";
	}


	
	

}

