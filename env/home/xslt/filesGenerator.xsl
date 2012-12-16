<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xs="http://www.w3.org/2001/XMLSchema"
				xmlns:fn="http://www.w3.org/2005/02/xpath-functions"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
				xmlns:nabla="http://nabla.mobi/nabla"
				extension-element-prefixes="nabla">

	<!--
	<xsl:output method="text" version="1.0" encoding="UTF-8" indent="no" media-type="text/plain"/>
	<xsl:output name="xmlOutput" method="xml" version="1.0" encoding="ASCII" indent="yes" media-type="xml" />
	-->

  	<xsl:output omit-xml-declaration="yes" indent="no"/>
  	
  	<xsl:param name="generationDirectory" select=" './' "/>
  		
  	<xsl:template match="/">
	   <xsl:result-document href="{nabla:filepath_to_uri( $generationDirectory )}/helpMapping.properties">  	  	
  	   <xsl:apply-templates/>
	   </xsl:result-document>    	   
  	</xsl:template>
  	
  	<xsl:template match="worksheetgroup">	
  	    	<xsl:value-of select="'&#10;'"/>
  	    	<xsl:text># </xsl:text>
  	    	<xsl:value-of select="@id"/>
  	    	<xsl:text> worksheetgroup help</xsl:text>
  	    	<xsl:value-of select="'&#10;'"/>
  	    	<xsl:apply-templates/>   	
  	</xsl:template>
  	
  	<xsl:template match="worksheet">
  	    	<xsl:value-of select="@id"/><xsl:text>=</xsl:text><xsl:value-of select="@olh"/>
  	    	<xsl:value-of select="'&#10;'"/>	    
  	</xsl:template>
	
</xsl:stylesheet>
