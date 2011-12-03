/* n4/metacompany/events/ParticpantAccess */
/**
 * <p>The module ParticipantAccess exports the enumeration of the
 * possible access policies for event participants.</p>
 *
 * <p><b>Enum 1 </b>: CLOSED.</p>
 * <p><b>Enum 2 </b>: PARTICIPANT_CAN_INVITE_OTHERS.</p>
 * <p><b>Enum 3 </b>: REQUESTABLE.</p>
 * <p><b>Enum 4 </b>: OPEN_FOR_SELF_INVITE.</p>
 *
 * @class
 * @namespace n4/metacompany/events
 */
var ParticipantAccess = module.exports = Enum([
    "CLOSED",
    "PARTICIPANT_CAN_INVITE_OTHERS",
    "REQUESTABLE",
    "OPEN_FOR_SELF_INVITE"
]);
