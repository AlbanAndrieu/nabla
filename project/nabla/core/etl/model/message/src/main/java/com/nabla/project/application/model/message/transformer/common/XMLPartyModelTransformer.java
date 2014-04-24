package com.nabla.project.application.model.message.transformer.common;

import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;

import com.nabla.project.application.model.message.domain.Party;
import com.nabla.project.application.model.message.transformer.ModelTransformer;
import com.nabla.project.application.model.xml.XMLId;
import com.nabla.project.application.model.xml.XMLParty;
import com.nabla.project.application.model.xml.XMLPartyIdentifier;
import com.nabla.project.application.model.xml.XMLTradePartyTypeScheme;

/**
 * Author : $author$ Date : $Date: 2010-06-14 12:02:51 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 */
public class XMLPartyModelTransformer extends ModelTransformer
{
    private Logger logger = Logger.getLogger(getClass());

    public Object transform(final Object nablaModel)
    {
        XMLParty transformedRbkModel = buildParty((Party) nablaModel);

        return new JAXBElement<XMLParty>(PARTY_QNAME, XMLParty.class, transformedRbkModel);
    } // end transform()

    public XMLParty buildParty(final Party party)
    {
        XMLPartyIdentifier identifier = XMLfactory.createXMLPartyIdentifier();

        // party/partyIdentifier/tradePartyId/id
        // party/partyIdentifier/tradePartyId/idScheme
        XMLId partyId = XMLfactory.createXMLId();
        partyId.setId(party.getId());

        switch (party.getType())
        {
            case EXTERNAL:
                partyId.setIdScheme(BACK_EXTERNALPARTY_SCHEME);

                break;

            case AGENCY:
                partyId.setIdScheme(BACK_PARTY_SCHEME);

                break;

            case PORTFOLIO:
                partyId.setIdScheme(BACK_PORTFOLIO_SCHEME);

                break;

            default:
                logger.warn("WARNING : " + party.getId() + " TYPTRS = " + party.getType());
                partyId.setIdScheme(BACK_UNKNOWN_SCHEME);
        } // end switch

        identifier.setTradePartyId(partyId);

        // party/partyIdentifier/tradePartyType
        switch (party.getType())
        {
            case EXTERNAL:
                identifier.setTradePartyType(XMLTradePartyTypeScheme.PARTY);

                break;

            case AGENCY:
                identifier.setTradePartyType(XMLTradePartyTypeScheme.BRANCH_OFFICE);

                break;

            case PORTFOLIO:
                identifier.setTradePartyType(XMLTradePartyTypeScheme.PORTFOLIO);

                break;

            default:
                logger.warn("WARNING : " + party.getId() + " TYPTRS = " + party.getType());
        } // end switch

        // party/partyIdentifier/tradePartyMnemonic
        identifier.setTradePartyMnemonic(party.getName());

        // party/partyIdentifier/tradePartyShortName
        identifier.setTradePartyShortName(party.getShortName());

        // root
        XMLParty partyRoot = XMLfactory.createXMLParty();
        partyRoot.setId(party.getReference());

        partyRoot.setPartyIdentifier(identifier);

        return partyRoot;
    } // end buildParty()
}
