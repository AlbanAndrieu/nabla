/* n4/metacompany/events/EventType */
/**
 * <p>The module EventType exports the enumeration of the
 * possible event types.</p>
 *
 * <p><b>Enum 1 </b>: UNDEFINED.</p>
 * <p><b>Enum 2 </b>: MEETING.</p>
 * <p><b>Enum 3 </b>: ONLINE_MEETING.</p>
 * <p><b>Enum 4 </b>: CALL</p>
 * <p><b>Enum 5 </b>: CONFERENCE_CALL.</p>
 * <p><b>Enum 6 </b>: VIDEO_CALL.</p>
 * <p><b>Enum 7 </b>: VIDEO_CONFERENCE.</p>
 * <p><b>Enum 8 </b>: LIVE_EVENT.</p>
 * <p><b>Enum 9 </b>: LIVE_BROADCAST.</p>
 * <p><b>Enum 10 </b>: EXHIBITION.</p>
 *
 * @class
 * @namespace n4/metacompany/events
 */
var EventType = module.exports = Enum([
    "UNDEFINED",
    "MEETING",
    "ONLINE_MEETING",
    "CALL",
    "CONFERENCE_CALL",
    "VIDEO_CALL",
    "VIDEO_CONFERENCE",
    "LIVE_EVENT",
    "LIVE_BROADCAST",
    "EXHIBITION"
]);
