package com.company.testspringbootappgradleassignment.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class BaseDbColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String label;
    private String type;
    @Transient
    private List<String> groupedValues;

    public BaseDbColumn(){}

    public BaseDbColumn(long id, String name, String label, String type, List<String> groupedValues) {
        this.id = id;
        this.name = name;
        this.label = label;
        this.type = type;
        this.groupedValues = groupedValues;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getGroupedValues() {
        return groupedValues;
    }

    public void setGroupedValues(List<String> groupedValues) {
        this.groupedValues = groupedValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseDbColumn that = (BaseDbColumn) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return groupedValues != null ? groupedValues.equals(that.groupedValues) : that.groupedValues == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (groupedValues != null ? groupedValues.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseDbColumn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", type='" + type + '\'' +
                ", groupedValues=" + groupedValues +
                '}';
    }
}
