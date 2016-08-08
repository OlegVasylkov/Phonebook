package ua.vasylkov.phonebook.model;

/**
 * Created by OlegVasylkov on 08.08.2016.
 */
public class BaseEntity {
    protected Integer id;

    public BaseEntity() {
    }

    protected BaseEntity(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return (this.id == null);
    }
}
