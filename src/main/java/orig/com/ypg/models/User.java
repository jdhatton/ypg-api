package orig.com.ypg.models;


import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.usertype.UserType;
import org.hibernate.validator.constraints.Email;
import orig.com.ypg.api.utils.DateUtil;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;



@Entity
@Table(name = "users")
public class User { // implements Owned {

	@Email
	@Column(unique = true, name = "userEmail")
	public String email;

	public String userFirstName;

	public String userLastName = "";

	public String gender;

	public String fbid;
	public String fb_access_token;

	// @Past (message = "validation.user.birthDatePast")
	// @CheckWith (Over13Check.class)
	@Temporal(TemporalType.TIMESTAMP)
	public Date birthDate;

	public String userPassword;

	@Transient
	public String userPasswordConfirm;

	@Temporal(TemporalType.TIMESTAMP)
	public Date registrationDate;

	@Temporal(TemporalType.TIMESTAMP)
	public Date deletedAt;

	@Temporal(TemporalType.TIMESTAMP)
	public Date emailVerificationDate;

	public String userUsername = "";

	public Integer notificationCount = 0;
	public String paymentId;
	public String paymentProfileId;
	public boolean deleted;
	public String emailVerificationTicket;

	// @Transient
	public String thumbnailURL;

	@Transient
	public UserType type;

	@Transient
	public String subscriptionId;

//	@OneToOne
//	@JoinColumn(name = "pictureAssetId")
//	public Asset picture;

//	@ManyToOne(fetch = FetchType.EAGER, optional = true)
//	@JoinColumn(name = "statusId", nullable = false, referencedColumnName = "id")
//	public UserStatus status;

	// @OneToMany (fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE},
	// mappedBy = "user")
	// public List<Notification> notifications;

	// @ManyToMany (fetch = FetchType.LAZY)
	// @JoinTable (name = "mapuserstotribes", joinColumns = {@JoinColumn (name =
	// "tribeId", referencedColumnName = "id")}, inverseJoinColumns =
	// {@JoinColumn (name = "userId", referencedColumnName = "id")})
	// public List<User> tribeMembers;

	// @ManyToMany (fetch = FetchType.LAZY)
	// @JoinTable (name = "mapuserstogroups", joinColumns = @JoinColumn (name =
	// "userId"), inverseJoinColumns = @JoinColumn (name = "groupId"))
	// public List<Group> groups;

	// @OneToMany (fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE},
	// mappedBy = "user")
	// public List<UserMessage> userMessages;

	public int getAge(Date birthDate, Date endDate) {
		return DateUtil.getAge(birthDate, endDate);
	}

	public Integer getAge() {
		return getAge(birthDate);
	}

	public int getAge(Date date) {
		return getAge(date, Calendar.getInstance().getTime());
	}


	public String getThumbnailUrl() {

		// if (thumbnailURL == null) return getDefaultPhotoUrl();
		// else return thumbnailURL;
		if (thumbnailURL == null ||  thumbnailURL.isEmpty() ) {
			return getDefaultPhotoUrl();
		} else {
			return thumbnailURL;
		}
	}


	private String getDefaultPhotoUrl() {
		if (gender == null) {
			return ("/public/images/dudeDefaultThumb.gif");
		}
		if (gender.equalsIgnoreCase("m")) {
			return ("/public/images/dudeDefaultThumb.gif");
		}
		return ("/public/images/ladyDefaultThumb.gif");
	}


	public boolean isAdministrator() {
		// return groups.contains(Group.find("byGroupName",
		// "Administrators").first());
		return true;
	}

	public boolean isMember() {
		if (deleted) {
			return false;
		}
		if (this.isAdministrator()) {
			return true;
		}
		return false;
	}

	public boolean verify(String ticket) {
		if ((!StringUtils.isEmpty(this.emailVerificationTicket))
				&& (this.emailVerificationDate == null)
				&& (this.emailVerificationTicket.equals(ticket))) {
			this.emailVerificationDate = new Date();
			return true;
		}

		return ((!StringUtils.isEmpty(this.emailVerificationTicket)) && (this.emailVerificationTicket
				.equals(ticket)));
	}

	public String generateNewEmailVerificationTicket() {
		emailVerificationTicket = RandomStringUtils.randomAlphanumeric(15);
		return emailVerificationTicket;
	}

	public String generateEmailVerificationTicket() {
		if (emailVerificationTicket != null)
			return emailVerificationTicket;
		this.emailVerificationTicket = RandomStringUtils.randomAlphanumeric(15);
		return emailVerificationTicket;
	}


	public String getUserFullname() {
		return userFirstName + " " + userLastName;
	}

	public String getBirthDateString() {
		return DateUtil.format(birthDate);
	}

	public String getRegistrationDateString() {
		return DateUtil.format(registrationDate);
	}

	// public boolean isTribeMember(User u) {
	// return tribeMembers.contains(u);
	// }

	/**
	 * Sees if the search term matches any of the following:
	 * <ul>
	 * <li>First name, substring, case-insensitive</li>
	 * <li>Last name, substring, case-insensitive</li>
	 * <li>Email, exact, case-insensitive</li>
	 * </ul>
	 * Does not trim the search term.
	 */
	public boolean match(String searchTerm) {
		if (StringUtils.containsIgnoreCase(this.userFirstName, searchTerm)) {
			return true;
		}
		if (StringUtils.containsIgnoreCase(this.userLastName, searchTerm)) {
			return true;
		}
		if (StringUtils.equalsIgnoreCase(this.email, searchTerm)) {
			return true;
		}
		return false;
	}

	public boolean match(Collection<String> searchTerms) {
		for (String searchTerm : searchTerms) {
			if (!this.match(searchTerm)) {
				return false;
			}
		}
		return true;
	}


}