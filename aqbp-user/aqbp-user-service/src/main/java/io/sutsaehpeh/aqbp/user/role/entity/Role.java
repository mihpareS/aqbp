package io.sutsaehpeh.aqbp.user.role.entity;

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
@Table(name = "aqbp_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name = "role_key", nullable = false, length = 50)
    private String roleKey;

    @Column(name = "role_type", nullable = false)
    private Integer roleType;

    @Column(name = "role_name", nullable = false, length = 50)
    private String roleName;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @Column(name = "role_desc", nullable = false, length = 100)
    private String roleDesc;

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
        Role role = (Role) o;
        return roleId != null && Objects.equals(roleId, role.roleId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}