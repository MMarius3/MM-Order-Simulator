package bll.validators;

/**
 * @author Macean Marius
 * @since Apr 06, 2021
 */
public interface Validator<T> {

    public void validate(T t);
}
