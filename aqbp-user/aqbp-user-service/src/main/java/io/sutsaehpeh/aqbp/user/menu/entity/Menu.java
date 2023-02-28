package io.sutsaehpeh.aqbp.user.menu.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "aqbp_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id", nullable = false)
    private Long menuId;

    @Column(name = "menu_name", nullable = false, length = 50)
    private String menuName;

    @Column(name = "menu_key", nullable = false, length = 100)
    private String menuKey;

    @Column(name = "component", nullable = false, length = 100)
    private String component;

    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    @Column(name = "target", nullable = false, length = 100)
    private String target;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @Column(name = "menu_type", nullable = false)
    private Integer menuType;

    @Column(name = "visible", nullable = false)
    private Integer visible;

    @Column(name = "path", nullable = false)
    private String path;

    @Column(name = "redirect", nullable = false)
    private String redirect;

    @Column(name = "gmt_created", nullable = false)
    private Date gmtCreated;

    @Column(name = "gmt_modified", nullable = false)
    private Date gmtModified;

    @Column(name = "delete_flag", nullable = false)
    private Long deleteFlag;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Menu menu = (Menu) o;
        return menuId != null && Objects.equals(menuId, menu.menuId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}