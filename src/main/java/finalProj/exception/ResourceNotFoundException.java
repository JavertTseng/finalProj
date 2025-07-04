package finalProj.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;	
	//ResourceNotFoundException 類別繼承了 RuntimeException，而 RuntimeException 是可序列化的
	//（implements Serializable），Eclipse建議加上一個serialVersionUID欄位來保持序列化相容性。

	public ResourceNotFoundException(String message) {
		super(message);
	}
}

