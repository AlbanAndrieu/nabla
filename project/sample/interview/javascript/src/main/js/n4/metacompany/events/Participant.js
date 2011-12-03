/* n4/metacompany/events/Participant */
var DataObject = require("n4/model/DataObject"),
    DataObjectRef = require("n4/model/DataObjectRef"),
    RSVPStatus = require("n4/metacompany/events/RSVPStatus");

/**
 * <p>The module exports the Participant data object
 * to represent participants of an event.</p>
 *
 * @class
 * @augments DataObject
 * @namespace n4/metacompany/events
 *
 * @requires RSVPStatus RSVPStatus.js
 */
// @memberOf DataObject
var Participant = module.exports = Class({
    isa: DataObject,
        has:
        /** @lends Participant# */
        {
        /**
         * Reference to the participant as an N4 User
         *
         * @type n4/model/DataObjectRef
         */
        userID: {
            type: DataObjectRef,
            init: null
        },
        /**
         * Email address
         *
         * @type String
         */
        email: {
            type: String,
            init: null
        },
        /**
         * Invitation date
         *
         * @type Date
         */
        invitationDate: {
            type: Date,
            init: new Date()
        },
        /**
         * Latest reply date
         *
         * @type Date
         */
        replyDate: {
            type: Date,
            init: new Date()
        },
        /**
         * <p>RSVP / invitation reply status</p>
         *
         * @type RSVPStatus
         * @default RSVPStatus.UNDEFINED
         */
        rsvpStatus: {
            type: RSVPStatus,
            init: RSVPStatus.UNDEFINED
        }
    }
});
