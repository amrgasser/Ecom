package org.example.Store.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "category", uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category extends AbstractModel<Long>{
    @ManyToOne
    private Category parentCategoryId;
    private String name;

}
