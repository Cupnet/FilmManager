package it.apuliadigitalmaker.studenti.filmmanager.mongodb.responseDto;

public class BaseResponseBody<T> {
	
	private boolean success;
	private String message;
	private String responseCode;
	private T data;
	
	public BaseResponseBody() {
		// TODO Auto-generated constructor stub
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BaseResponseBody [success=" + success + ", message=" + message + ", responseCode=" + responseCode
				+ ", data=" + data + "]";
	}

	public BaseResponseBody(boolean success, String message, String responseCode, T data) {
		super();
		this.success = success;
		this.message = message;
		this.responseCode = responseCode;
		this.data = data;
	}
	
	private BaseResponseBody(BaseResponseBodyBuilder<T> builder) {
		this.success = builder.success;
		this.data = builder.data;
		this.message = builder.message;
		this.responseCode = builder.responseCode;
	}
	
	public static class BaseResponseBodyBuilder<T> {
		private  boolean success;
		private  String message;
		private  String responseCode;
		private T data;
		
		public BaseResponseBodyBuilder() {}
		
		public BaseResponseBodyBuilder<T> success(boolean success) {
			this.success = success;
			return this;
		}
		
		public BaseResponseBodyBuilder<T> message(String message) {
			this.message = message;
			return this;
		}
		
		public BaseResponseBodyBuilder<T> responseCode(String responseCode) {
			this.responseCode = responseCode;
			return this;
		}
		
		public BaseResponseBodyBuilder<T> data(T data) {
			this.data = data;
			return this;
		}
		
		public BaseResponseBody<T> build() {
			return new BaseResponseBody<T>(this);
		}
	}
	
	public static <T> BaseResponseBodyBuilder<T> builder(){
		return new BaseResponseBodyBuilder<T>();
	}
	

}
