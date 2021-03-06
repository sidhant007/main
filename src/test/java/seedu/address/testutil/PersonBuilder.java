package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.attachment.Attachment;
import seedu.address.model.tag.Tag;
import seedu.address.model.task.Address;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Email;
import seedu.address.model.task.Name;
import seedu.address.model.task.Phone;
import seedu.address.model.task.Priority;
import seedu.address.model.task.Task;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Task objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_DEADLINE = "1/10/2018";
    public static final String DEFAULT_PRIORITY = "2";
    public static final String DEFAULT_EMAIL = "alice@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    private Name name;
    private Phone phone;
    private Priority priority;
    private Email email;
    private Deadline deadline;
    private Address address;
    private Set<Tag> tags;
    private Set<Attachment> attachments;

    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        priority = new Priority(DEFAULT_PRIORITY);
        email = new Email(DEFAULT_EMAIL);
        deadline = new Deadline(DEFAULT_DEADLINE);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
        attachments = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code taskToCopy}.
     */
    public PersonBuilder(Task taskToCopy) {
        name = taskToCopy.getName();
        phone = taskToCopy.getPhone();
        priority = taskToCopy.getPriority();
        email = taskToCopy.getEmail();
        deadline = taskToCopy.getDeadline();
        address = taskToCopy.getAddress();
        tags = new HashSet<>(taskToCopy.getTags());
        attachments = new HashSet<>(taskToCopy.getAttachments());
    }

    /**
     * Sets the {@code Name} of the {@code Task} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Task} that we are
     * building.
     */
    public PersonBuilder withTags(String... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Task} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Task} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Deadline} of the {@code Task} that we are building.
     */
    public PersonBuilder withDeadline(String deadline) {
        this.deadline = new Deadline(deadline);
        return this;
    }

    /**
     * Sets the {@code Priority} of the {@code Task} that we are building.
     */
    public PersonBuilder withPriority(String priority) {
        this.priority = new Priority(priority);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Task} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Parses the {@code attachments} into a {@code Set<Attachment>} and set it to the {@code Task} that we are
     * building.
     */
    public PersonBuilder withAttachments(Set<Attachment> attachments) {
        this.attachments = attachments;
        return this;
    }

    /**
     * Parses the {@code attachments} into a {@code Set<Attachment>} and set it to the {@code Task} that we are
     * building.
     */
    public PersonBuilder withAttachments(String... attachments) {
        this.attachments = SampleDataUtil.getAttachmentSet(attachments);
        return this;
    }

    public Task build() {
        return new Task(name, phone, priority, email, deadline, address, tags, attachments);
    }

}
