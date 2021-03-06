package seedu.address.storage;

import static org.junit.Assert.assertEquals;
import static seedu.address.storage.XmlAdaptedTask.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.TypicalPersons.BENSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.task.Address;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Email;
import seedu.address.model.task.Name;
import seedu.address.model.task.Phone;
import seedu.address.model.task.Priority;
import seedu.address.testutil.Assert;

public class XmlAdaptedTaskTest {

    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_PRIORITY = "b";
    private static final String INVALID_DEADLINE = "1002";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_PHONE = BENSON.getPhone().toString();
    private static final String VALID_PRIORITY = BENSON.getPriority().toString();
    private static final String VALID_DEADLINE = BENSON.getDeadline().toString();
    private static final String VALID_EMAIL = BENSON.getEmail().toString();
    private static final String VALID_ADDRESS = BENSON.getAddress().toString();
    private static final List<XmlAdaptedTag> VALID_TAGS = BENSON.getTags().stream()
        .map(XmlAdaptedTag::new)
        .collect(Collectors.toList());
    private static final List<XmlAdaptedAttachment> VALID_ATTACHMENTS = BENSON.getAttachments()
        .stream()
        .map(XmlAdaptedAttachment::new)
        .collect(Collectors.toList());

    @Test
    public void toModelType_validPersonDetails_returnsPerson() throws Exception {
        XmlAdaptedTask person = new XmlAdaptedTask(BENSON);
        assertEquals(BENSON, person.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        XmlAdaptedTask person =
            new XmlAdaptedTask(INVALID_NAME, VALID_PHONE, VALID_PRIORITY, VALID_DEADLINE, VALID_EMAIL, VALID_ADDRESS,
                VALID_TAGS, VALID_ATTACHMENTS);
        String expectedMessage = Name.MESSAGE_NAME_CONSTRAINTS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        XmlAdaptedTask person = new XmlAdaptedTask(null, VALID_PHONE, VALID_PRIORITY, VALID_DEADLINE, VALID_EMAIL,
            VALID_ADDRESS,
            VALID_TAGS, VALID_ATTACHMENTS);
        String expectedMessage = String
            .format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        XmlAdaptedTask person =
            new XmlAdaptedTask(VALID_NAME, INVALID_PHONE, VALID_PRIORITY, VALID_DEADLINE, VALID_EMAIL, VALID_ADDRESS,
                VALID_TAGS, VALID_ATTACHMENTS);
        String expectedMessage = Phone.MESSAGE_PHONE_CONSTRAINTS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullPhone_throwsIllegalValueException() {
        XmlAdaptedTask person = new XmlAdaptedTask(VALID_NAME, null, VALID_PRIORITY, VALID_DEADLINE, VALID_EMAIL,
            VALID_ADDRESS,
            VALID_TAGS, VALID_ATTACHMENTS);
        String expectedMessage = String
            .format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidPriority_throwsIllegalValueException() {
        XmlAdaptedTask person =
            new XmlAdaptedTask(VALID_NAME, VALID_PHONE, INVALID_PRIORITY, VALID_DEADLINE, VALID_EMAIL, VALID_ADDRESS,
                VALID_TAGS, VALID_ATTACHMENTS);
        String expectedMessage = Priority.MESSAGE_PRIORITY_CONSTRAINTS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullPriority_throwsIllegalValueException() {
        XmlAdaptedTask person = new XmlAdaptedTask(VALID_NAME, VALID_PHONE, null, VALID_DEADLINE, VALID_EMAIL,
            VALID_ADDRESS,
            VALID_TAGS, VALID_ATTACHMENTS);
        String expectedMessage = String
            .format(MISSING_FIELD_MESSAGE_FORMAT, Priority.class.getSimpleName());
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidDeadline_throwsIllegalValueException() {
        XmlAdaptedTask person =
            new XmlAdaptedTask(VALID_NAME, VALID_PHONE, VALID_PRIORITY, INVALID_DEADLINE, VALID_EMAIL, VALID_ADDRESS,
                VALID_TAGS, VALID_ATTACHMENTS);
        String expectedMessage = Deadline.MESSAGE_DEADLINE_CONSTRAINTS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullDeadline_throwsIllegalValueException() {
        XmlAdaptedTask person = new XmlAdaptedTask(VALID_NAME, VALID_PHONE, VALID_PRIORITY, null, VALID_EMAIL,
            VALID_ADDRESS,
            VALID_TAGS, VALID_ATTACHMENTS);
        String expectedMessage = String
            .format(MISSING_FIELD_MESSAGE_FORMAT, Deadline.class.getSimpleName());
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        XmlAdaptedTask person =
            new XmlAdaptedTask(VALID_NAME, VALID_PHONE, VALID_PRIORITY, VALID_DEADLINE, INVALID_EMAIL, VALID_ADDRESS,
                VALID_TAGS, VALID_ATTACHMENTS);
        String expectedMessage = Email.MESSAGE_EMAIL_CONSTRAINTS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        XmlAdaptedTask person = new XmlAdaptedTask(VALID_NAME, VALID_PHONE, VALID_PRIORITY, VALID_DEADLINE, null,
            VALID_ADDRESS,
            VALID_TAGS, VALID_ATTACHMENTS);
        String expectedMessage = String
            .format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidAddress_throwsIllegalValueException() {
        XmlAdaptedTask person =
            new XmlAdaptedTask(VALID_NAME, VALID_PHONE, VALID_PRIORITY, VALID_DEADLINE, VALID_EMAIL, INVALID_ADDRESS,
                VALID_TAGS, VALID_ATTACHMENTS);
        String expectedMessage = Address.MESSAGE_ADDRESS_CONSTRAINTS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullAddress_throwsIllegalValueException() {
        XmlAdaptedTask person = new XmlAdaptedTask(VALID_NAME, VALID_PHONE, VALID_PRIORITY, VALID_DEADLINE, VALID_EMAIL,
            null,
            VALID_TAGS, VALID_ATTACHMENTS);
        String expectedMessage = String
            .format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName());
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<XmlAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new XmlAdaptedTag(INVALID_TAG));
        XmlAdaptedTask person =
            new XmlAdaptedTask(VALID_NAME, VALID_PHONE, VALID_PRIORITY, VALID_DEADLINE, VALID_EMAIL, VALID_ADDRESS,
                invalidTags, VALID_ATTACHMENTS);
        Assert.assertThrows(IllegalValueException.class, person::toModelType);
    }

}
