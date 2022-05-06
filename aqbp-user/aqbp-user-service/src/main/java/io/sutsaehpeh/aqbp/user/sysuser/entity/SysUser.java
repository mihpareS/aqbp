package io.sutsaehpeh.aqbp.user.sysuser.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "aqbp_user")
@DynamicInsert
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", insertable = false, unique = true)
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name = "email")
    private String email;

    @Column(name = "user_avatar")
    private String userAvatar;

    @Column(name = "user_status")
    private Integer userStatus;

    @Column(name = "user_type")
    private Integer userType;

    @Column(name = "register_date")
    private Date registerDate;

    @Column(name = "gmt_created")
    private Date gmtCreated;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SysUser sysUser = (SysUser) o;
        return userId != null && Objects.equals(userId, sysUser.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
