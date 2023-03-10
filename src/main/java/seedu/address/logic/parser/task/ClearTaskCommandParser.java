package seedu.address.logic.parser.task;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;

import java.util.stream.Stream;

import seedu.address.logic.commands.task.ClearTaskCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.task.Date;

/**
 * Parses input arguments and creates a new ClearTaskCommand object
 */
public class ClearTaskCommandParser implements Parser<ClearTaskCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ClearTaskCommand
     * and returns a ClearTaskCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ClearTaskCommand parse(String args) throws ParseException {
        try {
            ArgumentMultimap argMultimap =
                    ArgumentTokenizer.tokenize(args, PREFIX_DATE);

            //check if the given string is empty (or contains only whitespace)
            if (args.isBlank()) {
                return new ClearTaskCommand();
            }

            if (!arePrefixesPresent(argMultimap, PREFIX_DATE) || !argMultimap.getPreamble().isEmpty()) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ClearTaskCommand.MESSAGE_USAGE));
            }

            Date date = ParserUtil.parseDate(argMultimap.getValue(PREFIX_DATE).get());

            return new ClearTaskCommand(date);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ClearTaskCommand.MESSAGE_USAGE), pe);
        }
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
