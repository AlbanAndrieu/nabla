/* n4/metacompany/events/RSVPStatus */
/**
 * <p>The module RSVPStatus exports the enumeration of the
 * status values for event RSVP / invitation reply.</p>
 *
 * @class
 * @namespace n4/metacompany/events
 * @property {enum} UNDEFINED - No reply.
 * @property {enum} YES - Participants have replied yes.
 * @property {enum} NO - Participants have replied no.
 * @property {enum} MAYBE -  Replied, tentative.
 */
var RSVPStatus = module.exports = Enum([
    "UNDEFINED",
    "YES",
    "NO",
    "MAYBE"
]);
