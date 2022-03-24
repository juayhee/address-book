package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AddTagCommand;
import seedu.address.logic.commands.AddTaskCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.ClearTaskCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteTagCommand;
import seedu.address.logic.commands.DeleteTaskCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.FindTaskCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.ListTaskCommand;
import seedu.address.logic.commands.notecommands.AddMiscCommand;
import seedu.address.logic.commands.notecommands.AddStrengthCommand;
import seedu.address.logic.commands.notecommands.AddWeaknessCommand;
import seedu.address.logic.commands.notecommands.DeleteMiscCommand;
import seedu.address.logic.commands.notecommands.DeleteStrengthCommand;
import seedu.address.logic.commands.notecommands.DeleteWeaknessCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.notecommandparsers.AddMiscCommandParser;
import seedu.address.logic.parser.notecommandparsers.AddStrengthCommandParser;
import seedu.address.logic.parser.notecommandparsers.AddWeaknessCommandParser;
import seedu.address.logic.parser.notecommandparsers.DeleteMiscCommandParser;
import seedu.address.logic.parser.notecommandparsers.DeleteStrengthCommandParser;
import seedu.address.logic.parser.notecommandparsers.DeleteWeaknessCommandParser;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case AddTaskCommand.COMMAND_WORD:
            return new AddTaskCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case DeleteTaskCommand.COMMAND_WORD:
            return new DeleteTaskCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case ClearTaskCommand.COMMAND_WORD:
            return new ClearTaskCommandParser().parse(arguments);

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case FindTaskCommand.COMMAND_WORD:
            return new FindTaskCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ListTaskCommand.COMMAND_WORD:
            return new ListTaskCommand();

        case AddStrengthCommand.COMMAND_WORD:
            return new AddStrengthCommandParser().parse(arguments);

        case AddWeaknessCommand.COMMAND_WORD:
            return new AddWeaknessCommandParser().parse(arguments);

        case AddMiscCommand.COMMAND_WORD:
            return new AddMiscCommandParser().parse(arguments);

        case DeleteStrengthCommand.COMMAND_WORD:
            return new DeleteStrengthCommandParser().parse(arguments);

        case DeleteWeaknessCommand.COMMAND_WORD:
            return new DeleteWeaknessCommandParser().parse(arguments);

        case DeleteMiscCommand.COMMAND_WORD:
            return new DeleteMiscCommandParser().parse(arguments);

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case AddTagCommand.COMMAND_WORD:
            return new AddTagCommandParser().parse(arguments);

        case DeleteTagCommand.COMMAND_WORD:
            return new DeleteTagCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
