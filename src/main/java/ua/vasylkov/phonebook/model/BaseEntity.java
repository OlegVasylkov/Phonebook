package ua.vasylkov.phonebook.model;

/**
 * Created by OlegVasylkov on 08.08.2016.
 */
public class BaseEntity {
    public static final int START_SEQ = 10000;

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

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null || getClass()!= obj.getClass()) return false;
        BaseEntity that = (BaseEntity) obj;
        if (id == null || that.getId() == null) return false;
        return this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }
}
