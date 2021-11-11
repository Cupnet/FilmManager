package it.apuliadigitalmaker.studenti.filmmanager.mongodb.responseDto;

public class CategoryResponseDto {
	
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

	public CategoryResponseDto() {
		super();
	}

	public CategoryResponseDto(String name, Long id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "CategoryResponseDto [name=" + name + ", id=" + id + "]";
	}


	
	

}
