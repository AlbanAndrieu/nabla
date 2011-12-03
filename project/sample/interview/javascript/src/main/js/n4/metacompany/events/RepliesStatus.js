/* n4/metacompany/events/RepliesStatus */
var DataObject = require("n4/model/DataObject"),
    EventStatus = require("n4/metacompany/events/EventStatus");

/**
 * The module exports the RepliesStatus data object
 * to represent the status of participants' replies to an event
 * @class
 * @namespace n4/metacompany/events
 *
 * @requires EventStatus EventStatus.js  
 */ 
// @memberOf DataObject
var RepliesStatus = module.exports = Class({
    isa: DataObject,
    has: 
    /** @lends RepliesStatus# */
    {
        /**
         * <p>Overall event replies status: open / complete</p>
         * @type EventStatus
         * @default EventStatus.RSVP_OPEN
         */
        status: {
            type: EventStatus,
            init: EventStatus.RSVP_OPEN
        },
        /**
         * Number of pending replies
         * @type Number
         */
        numberPending: {
            type: Number,
            init: null
        },
        /**
         * Latest reply date
         * @type Date
         */
        replyDate: {
            type: Date,
            init: new Date()
        }
    }
});
