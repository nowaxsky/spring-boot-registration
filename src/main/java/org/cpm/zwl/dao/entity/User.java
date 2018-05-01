package org.cpm.zwl.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "T_USER")
public class User implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 4692861845419054946L;

  @Id
  @SequenceGenerator(name = "sequence", sequenceName = "t_user_user_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
  @Column(name = "USER_ID")
  private Long userId;

  @Column(name = "USERNAME")
  private String username;

  @Column(name = "PASSWORD")
  private String password;

  @Transient
  private String passwordConfirm;

  @ManyToMany
  @JoinTable(name = "T_USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"),
      inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
  private Set<Role> roles;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPasswordConfirm() {
    return passwordConfirm;
  }

  public void setPasswordConfirm(String passwordConfirm) {
    this.passwordConfirm = passwordConfirm;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
