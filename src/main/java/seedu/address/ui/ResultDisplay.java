package seedu.address.ui;

import java.util.logging.Logger;

import com.google.common.eventbus.Subscribe;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.ui.NewResultAvailableEvent;
import seedu.address.commons.events.ui.NewRichResultAvailableEvent;

/**
 * A ui for the status bar that is displayed at the header of the application.
 */
public class ResultDisplay extends UiPart<Region> {

    public static final String TEXT_STYLE_CLASS_DEFAULT = "result-display-text";
    public static final String TEXT_STYLE_CLASS_ERROR = "result-display-text-error";

    private static final Logger logger = LogsCenter.getLogger(ResultDisplay.class);
    private static final String FXML = "ResultDisplay.fxml";

    private final ObservableList<Node> displayed;

    @FXML
    private TextFlow resultDisplay;

    public ResultDisplay() {
        super(FXML);
        displayed = resultDisplay.getChildren();
        registerAsAnEventHandler(this);
    }

    @Subscribe
    private void handleNewResultAvailableEvent(NewResultAvailableEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
        Platform.runLater(() -> {
            displayed.clear();
            Text text = new Text(event.message);
            text.getStyleClass().add(TEXT_STYLE_CLASS_DEFAULT);
            displayed.add(text);
        });
    }

    @Subscribe
    private void handleNewRickResultAvailableEvent(NewRichResultAvailableEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
        Platform.runLater(() -> {
            displayed.clear();
            for (StyledText styledText : event.message) {
                Text text = new Text(styledText.text);
                text.getStyleClass().add(styledText.styleClass);
                displayed.add(text);
            }
        });
    }

    public static class StyledText {
        public final String text;
        public final String styleClass;

        public StyledText(String text, String styleClass) {
            this.text = text;
            this.styleClass = styleClass;
        }
    }

}
