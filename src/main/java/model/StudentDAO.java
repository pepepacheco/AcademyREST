package model;

import java.util.List;

/**
 *
 * @author Rafael Vargas del Moral
 */

public interface StudentDAO {
    List<StudentDTO> findAll();
}
