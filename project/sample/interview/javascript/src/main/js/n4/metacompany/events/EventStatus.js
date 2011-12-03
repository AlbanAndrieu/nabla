/* n4/metacompany/events/EventStatus */
/**
 * <p>The module EventStatus exports the enumeration of the
 * status values for an event.</p>
 *
 * @class
 * @namespace n4/metacompany/events
 * @property {enum} RSVP_OPEN - There are still some pending replies from participants.
 * @property {enum} RSVP_COMPLETE - All participants have replied.
 */
var EventStatus = module.exports = Enum([
    "RSVP_OPEN",
    "RSVP_COMPLETE"
]);
