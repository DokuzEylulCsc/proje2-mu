package mu.Project.Models;

public interface Model {

    /**
     * Insert or update to database.
     */
    void save();

    /**
     * Delete from database if exists.
     */
    void delete();

}
