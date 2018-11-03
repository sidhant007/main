package seedu.address.logic.parser.exceptions;

import java.util.ArrayList;
import java.util.List;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.ui.ResultDisplay;

/**
 * Represents a parse error encountered by a parser that contains rich formatting.
 */
public class RichParseException extends IllegalValueException {

    public final List<ResultDisplay.StyledText> message;

    public RichParseException(String... parts) {
        this(makeMessage(parts));
    }

    public RichParseException(List<ResultDisplay.StyledText> message) {
        this(message, null);
    }

    public RichParseException(List<ResultDisplay.StyledText> message, Throwable cause) {
        super(message.toString(), cause);
        this.message = message;
    }

    /**
     * Converts a list of text parts and associated style classes into the whole rich message.
     */
    private static List<ResultDisplay.StyledText> makeMessage(String[] parts) {
        assert(parts.length % 2 == 0);
        List<ResultDisplay.StyledText> result = new ArrayList<>();
        for (int i = 0; i < parts.length; i += 2) {
            result.add(new ResultDisplay.StyledText(parts[i], parts[i + 1]));
        }
        return result;
    }
}
