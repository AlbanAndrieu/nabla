/* n4/metacompany/events/Event */
/*
* @fileoverview Documentation sample.
* @author Rachael Brooke
* @version 0.1
*/
var Entity = require("n4/metacompany/Entity"),
    ParticipantAccess = require("n4/metacompany/events/ParticipantAccess"),
    EventType = require("n4/metacompany/events/EventType"),
    PrivacyLevel = require("n4/metacompany/events/PrivacyLevel"),
    RepliesStatus = require("n4/metacompany/events/RepliesStatus"),
    DataObjectRef = require("n4/model/DataObjectRef"),
    List = require("n4/lang/List");

/**
 * <p>Module Exports the Event Entity implementation.</p>
 *
 * @class
 * @namespace n4/metacompany/events
 * @augments Entity
 *
 * @requires ParticipantAccess ParticipantAccess.js
 * @requires EventType EventType.js
 * @requires PrivacyLevel PrivacyLevel.js
 * @requires RepliesStatus RepliesStatus.js
 */
// @memberOf Entity
// @memberOf n4/metacompany/events
var Event = module.exports = Class({
    isa: Entity,
    my: {
        has: {
            endpoint: "events"
        }
    },
    has:
    /** @lends Event# */
    {
        /**
         * Event title
         * @type String
         */
        title: {
            type: String,
            init: null
        },
        /**
         * User description of the event
         * @type String
         */
        description: {
            type: String,
            init: null
        },
        /**
         * <p>Event address
         * Can be a street address, room name, URL, conf. call number, anything</p>
         *
         * @type String
         */
        address: {
            type: String,
            init: null
        },
        /**
         * Reference to N4 User who is the owner / creator of this event
         * @type n4/model/DataObjectRef
         */
        owner: {
            type: DataObjectRef,
            init: null
        },
        /**
         * <p>The overall status of participants' replies to an event :
         * <li>did everyone reply yet?</li>
         * <li>how many pending replies are left?</li>
         * <li>last reply date</li>
         * </p>
         *
         * @type RepliesStatus
         */
        repliesStatus: {
            type: RepliesStatus,
            init: new RepliesStatus()
        },
        /**
         * The list of event participants
         *
         * @type List of Participant
         * @see n4/lang/List
         * @link Participant
         */
        participants: {
            type: List,
            init: function() {
                return new List();
            }
        },
        /**
         * <p>Participant access policy</p>
         *
         * <p>Event is closed by default
         * (only those explicitly invited have the access)</p>
         *
         * @type ParticipantAccess
         * @default ParticipantAccess.CLOSED
         */
        participantAccess: {
            type: ParticipantAccess,
            init: ParticipantAccess.CLOSED
        },
        /**
         * <p>Event privacy level (PRIVATE/ORGANIZATION/PUBLIC)</p>
         *
         * @type PrivacyLevel
         * @default PrivacyLevel.PRIVATE
         */
        privacyLevel: {
            type: PrivacyLevel,
            init: PrivacyLevel.PRIVATE
        },
        /**
         * <p>Event type: meeting / conf. call / exhibition / etc</p>
         *
         * @type EventType
         * @default EventType.UNDEFINED
         */
        eventType: {
            type: EventType,
            init: EventType.UNDEFINED
        },
        /**
         * Is this an all-day event?
         * (as opposed to scheduled hours only)
         *
         * @type Boolean
         * @default false
         */
        isAllDayEvent: {
            type: Boolean,
            init: false
        },
        /**
         * Event time zone
         * @type String
         */
        timeZone: {
            type: String,
            init: null
        },
        /**
         * Event start time
         * @type Date
         */
        startTime: {
            type: Date,
            init: new Date()
        },
        /**
         * Event end time
         * @type Date
         */
        endTime: {
            type: Date,
            init: new Date()
        },
        /**
         * The list of resources used for event
         * (reserved rooms, etc.)
         *
         * @type List of String or DataObjectRef
         * @see n4/lang/List
         * @link String
         * @link n4/model/DataObjectRef
         */
        resources: {
            type: List,
            init: function() {
                return new List();
            }
        },
        /**
         * The list of event attachments
         *
         * @type List of DataObjectRef
         * @see n4/lang/List
         * @link n4/model/DataObjectRef
         */
        attachments: {
            type: List,
            init: function() {
                return new List();
            }
        }
    },
    /** @lends Event# */
    methods: {
    }
});
