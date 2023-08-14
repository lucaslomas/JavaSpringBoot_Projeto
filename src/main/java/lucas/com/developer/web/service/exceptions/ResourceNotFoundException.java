package lucas.com.developer.web.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Long id){
        super("Resource not found. Id " + id);
    }

}
