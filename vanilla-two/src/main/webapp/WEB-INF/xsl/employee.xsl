<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0">
    <xsl:output method="html" indent="yes" />
    <xsl:template match="/">
        <html>
            <head>
                <title>Render with XSLT</title>
            </head>
            <body>
                <div align="center">
                    <xsl:apply-templates />
                </div>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="citizens">
        <table border="1" width="100%">
            <xsl:for-each select="citizen">
                <tr>
                    <td>
                        <xsl:value-of select="ssn" />
                    </td>
                    <td>
                        <xsl:value-of select="firstname" />
                    </td>
                    <td>
                        <xsl:value-of select="lastname" />
                    </td>
                    <td>
                        <xsl:value-of select="role" />
                    </td>
                    <td>
                        <xsl:value-of select="salary" />
                    </td>

                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>