/*
 *  This file is part of MxUpdate <http://www.mxupdate.org>.
 *
 *  MxUpdate is a deployment tool for a PLM platform to handle
 *  administration objects as single update files (configuration item).
 *
 *  Copyright (C) 2008-2016 The MxUpdate Team - All Rights Reserved
 *
 *  You may use, distribute and modify MxUpdate under the terms of the
 *  MxUpdate license. You should have received a copy of the MxUpdate
 *  license with this file. If not, please write to <info@mxupdate.org>,
 *  or visit <www.mxupdate.org>.
 *
 */

package org.mxupdate.test.update.datamodel;

import java.io.StringReader;
import java.lang.reflect.Method;

import org.mxupdate.test.AbstractTest;
import org.mxupdate.update.datamodel.Dimension_mxJPO;
import org.mxupdate.update.datamodel.dimension.DimensionDefParser_mxJPO;
import org.mxupdate.update.util.ParameterCache_mxJPO;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Class is used to test the dimension parser {@link DimensionDefParser_mxJPO} with
 * some examples.
 *
 * @author The MxUpdate Team
 */
public class DimensionParserTest
    extends AbstractTest
{
    /** Name of the test dimension. */
    private static final String DIMENSION_NAME = AbstractTest.PREFIX + "_Test";

    /** Start of the command to update the dimension to extract the code. */
    private static final String START_INDEX = "mxUpdate dimension \"${NAME}\" {";
    /** Length of the string of the command to update the dimension. */
    private static final int START_INDEX_LENGTH = DimensionParserTest.START_INDEX.length();

    /**
     * Removes the MxUpdate test dimensions.
     *
     * @throws Exception if MQL execution failed
     */
    @BeforeMethod()
    @AfterClass()
    public void cleanup()
        throws Exception
    {
        this.cleanup(AbstractTest.CI.DM_DIMENSION);
    }

    /**
     * Returns data providers used for testing parses.
     *
     * @return test source code to parse
     */
    @DataProvider(name = "dimensions")
    public Object[][] getCodes()
    {
        return new Object[][]{
                new Object[]{
                        "1) simple hidden dimension definition without units",
                        "",
                        "description \"\" hidden"},
                new Object[]{
                        "2a) simple not hidden dimension",
                        "",
                        "description \"\" !hidden"},
                new Object[]{
                        "2b) simple not hidden dimension definition defined as value w/o apostrophe",
                        "description \"\" !hidden",
                        "description \"\" hidden FALSE"},
                new Object[]{
                        "2c) simple not hidden dimension definition defined as value with apostrophe",
                        "description \"\" !hidden",
                        "description \"\" hidden \"false\""},
                new Object[]{
                        "2d) simple hidden dimension definition",
                        "",
                        "description \"\" hidden"},
                new Object[]{
                        "2e) simple hidden dimension definition defined as value w/o apostrophe",
                        "description \"\" hidden",
                        "description \"\" hidden TRUE"},
                new Object[]{
                        "2f) simple hidden dimension definition defined as value with apostrophe",
                        "description \"\" hidden",
                        "description \"\" hidden \"True\""},
                new Object[]{
                          "3a) dimension with simple default unit",
                          "",
                          "description \"\"\n"
                        + "!hidden\n"
                        + "unit \"name1\" {\n"
                        + "  default\n"
                        + "  description \"\"\n"
                        + "  label \"\"\n"
                        + "  multiplier 1.0\n"
                        + "  offset 0.0\n"
                        + "}\n"
                        + "unit \"name2\" {\n"
                        + "  description \"\"\n"
                        + "  label \"\"\n"
                        + "  multiplier -10.0\n"
                        + "  offset 20.0\n"
                        + "}",
                },
                new Object[]{
                        "3b) dimension with simple default unit defined as value w/o apostrophe",
                        "description \"\"\n"
                      + "!hidden\n"
                      + "unit \"name1\" {\n"
                      + "  default\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier 1.0\n"
                      + "  offset 0.0\n"
                      + "}\n"
                      + "unit \"name2\" {\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier -10.0\n"
                      + "  offset 20.0\n"
                      + "}",
                        "description \"\"\n"
                      + "!hidden\n"
                      + "unit \"name1\" {\n"
                      + "  default true\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier 1.0\n"
                      + "  offset 0.0\n"
                      + "}\n"
                      + "unit \"name2\" {\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier -10.0\n"
                      + "  offset 20.0\n"
                      + "}",
                },
                new Object[]{
                        "3c) dimension with simple default unit defined as value with apostrophe",
                        "description \"\"\n"
                      + "!hidden\n"
                      + "unit \"name1\" {\n"
                      + "  default\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier 1.0\n"
                      + "  offset 0.0\n"
                      + "}\n"
                      + "unit \"name2\" {\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier -10.0\n"
                      + "  offset 20.0\n"
                      + "}",
                        "description \"\"\n"
                      + "!hidden\n"
                      + "unit \"name1\" {\n"
                      + "  default \"TRUE\"\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier 1.0\n"
                      + "  offset 0.0\n"
                      + "}\n"
                      + "unit \"name2\" {\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier -10.0\n"
                      + "  offset 20.0\n"
                      + "}",
                },
                new Object[]{
                        "3d) dimension with simple default unit and not default",
                        "description \"\"\n"
                      + "!hidden\n"
                      + "unit \"name1\" {\n"
                      + "  default\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier 1.0\n"
                      + "  offset 0.0\n"
                      + "}\n"
                      + "unit \"name2\" {\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier -10.0\n"
                      + "  offset 20.0\n"
                      + "}",
                        "description \"\"\n"
                      + "!hidden\n"
                      + "unit \"name1\" {\n"
                      + "  default\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier 1.0\n"
                      + "  offset 0.0\n"
                      + "}\n"
                      + "unit \"name2\" {\n"
                      + "  !default\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier -10.0\n"
                      + "  offset 20.0\n"
                      + "}",
                },
                new Object[]{
                        "3e) dimension with simple default unit and not default as value w/o apostrophe",
                        "description \"\"\n"
                      + "!hidden\n"
                      + "unit \"name1\" {\n"
                      + "  default\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier 1.0\n"
                      + "  offset 0.0\n"
                      + "}\n"
                      + "unit \"name2\" {\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier -10.0\n"
                      + "  offset 20.0\n"
                      + "}",
                        "description \"\"\n"
                      + "!hidden\n"
                      + "unit \"name1\" {\n"
                      + "  default\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier 1.0\n"
                      + "  offset 0.0\n"
                      + "}\n"
                      + "unit \"name2\" {\n"
                      + "  default FALSE\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier -10.0\n"
                      + "  offset 20.0\n"
                      + "}",
                },
                new Object[]{
                        "3f) dimension with simple default unit and not default as value with apostrophe",
                        "description \"\"\n"
                      + "!hidden\n"
                      + "unit \"name1\" {\n"
                      + "  default\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier 1.0\n"
                      + "  offset 0.0\n"
                      + "}\n"
                      + "unit \"name2\" {\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier -10.0\n"
                      + "  offset 20.0\n"
                      + "}",
                        "description \"\"\n"
                      + "!hidden\n"
                      + "unit \"name1\" {\n"
                      + "  default\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier 1.0\n"
                      + "  offset 0.0\n"
                      + "}\n"
                      + "unit \"name2\" {\n"
                      + "  default \"false\"\n"
                      + "  description \"\"\n"
                      + "  label \"\"\n"
                      + "  multiplier -10.0\n"
                      + "  offset 20.0\n"
                      + "}",
                },
                new Object[]{
                        "4) complex dimension definition",
                        "",
                          "description \"ein test\"\n"
                        + "!hidden\n"
                        + "unit \"name1\" {\n"
                        + "  default\n"
                        + "  description \"description1\"\n"
                        + "  label \"label1\"\n"
                        + "  multiplier 1.0\n"
                        + "  offset 0.0\n"
                        + "  setting \"SettingKey2\" \"SettingValue2\"\n"
                        + "  setting \"to\" \"SettingValue\"\n"
                        + "  property \"Zest\" value \"Zest\"\n"
                        + "  property \"_test3\" value \"Test3\"\n"
                        + "  property \"abc\" value \"abc\"\n"
                        + "  property \"abc2\" value \"abc2\"\n"
                        + "  property \"test\" to type \"Part\" value \"Test\"\n"
                        + "  property \"test2\" value \"Test2\"\n"
                        + "}\n"
                        + "unit \"name2\" {\n"
                        + "  description \"description 2\"\n"
                        + "  label \"label2\"\n"
                        + "  multiplier 10.0\n"
                        + "  offset 20.0\n"
                        + "  system \"Duration Units\" to unit \"name2\"\n"
                        + "}",
                },
                new Object[]{
                        "5) dimension with unit with negative offset",
                        "",
                        "description \"ein test\"\n"
                        + "!hidden\n"
                        + "unit \"name1\" {\n"
                        + "  default\n"
                        + "  description \"description1\"\n"
                        + "  label \"label1\"\n"
                        + "  multiplier 1.0\n"
                        + "  offset 0.0\n"
                        + "}\n"
                        + "unit \"name2\" {\n"
                        + "  description \"description 2\"\n"
                        + "  label \"label2\"\n"
                        + "  multiplier 10.0\n"
                        + "  offset -20.0\n"
                        + "}",
                },
                new Object[]{
                        "6) dimension with unit with negative multiplier",
                        "",
                        "description \"ein test\"\n"
                        + "!hidden\n"
                        + "unit \"name1\" {\n"
                        + "  default\n"
                        + "  description \"description1\"\n"
                        + "  label \"label1\"\n"
                        + "  multiplier 1.0\n"
                        + "  offset 0.0\n"
                        + "}\n"
                        + "unit \"name2\" {\n"
                        + "  description \"description 2\"\n"
                        + "  label \"label2\"\n"
                        + "  multiplier -10.0\n"
                        + "  offset 20.0\n"
                        + "}",
                },
                new Object[]{
                        "7) dimension with unit with integer number",
                        "description \"ein test\"\n"
                        + "!hidden\n"
                        + "unit \"name1\" {\n"
                        + "  default\n"
                        + "  description \"\"\n"
                        + "  label \"\"\n"
                        + "  multiplier 1.0\n"
                        + "  offset 0.0\n"
                        + "}",
                        "description \"ein test\"\n"
                        + "!hidden\n"
                        + "unit \"name1\" {\n"
                        + "  default\n"
                        + "  multiplier 1\n"
                        + "  offset 0\n"
                        + "}"
                }
        };
    }

    /**
     * Parsed the <code>_definition</code> code and compares the result with
     * <code>_toTest</code>.
     *
     * @param _description  description of the test
     * @param _toTest       expected result (if empty string
     *                      <code>_definition</code> is the expected result)
     * @param _definition   text of the definition to test
     * @throws Exception if <code>_definition</code> could not parsed
     */
    @Test(dataProvider = "dimensions")
    public void testDimension(final String _description,
                              final String _toTest,
                              final String _definition)
        throws Exception
    {
        final ParameterCache_mxJPO paramCache = new ParameterCache_mxJPO(this.getContext(), false);

        this.mql("add dimension " + DimensionParserTest.DIMENSION_NAME);

        final DimensionDefParser_mxJPO parser = new DimensionDefParser_mxJPO(new StringReader(_definition));
        final Dimension_mxJPO dimension = parser.parse(paramCache,
                                                       paramCache.getMapping().getTypeDef("Dimension"),
                                                       DimensionParserTest.DIMENSION_NAME);

        final StringBuilder generated = new StringBuilder();
        final Method write = dimension.getClass()
                .getDeclaredMethod("write", ParameterCache_mxJPO.class, Appendable.class);
        write.setAccessible(true);
        write.invoke(dimension, paramCache, generated);

        final StringBuilder oldDefBuilder = new StringBuilder();
        for (final String line : _toTest.isEmpty() ? _definition.split("\n") : _toTest.split("\n"))  {
            oldDefBuilder.append(line.trim()).append(' ');
        }
        int length = 0;
        String oldDef = oldDefBuilder.toString();
        while (length != oldDef.length())  {
            length = oldDef.length();
            oldDef = oldDef.replaceAll("  ", " ");
        }

        final String temp = generated.substring(generated.indexOf(DimensionParserTest.START_INDEX) + DimensionParserTest.START_INDEX_LENGTH + 1, generated.length() - 2).toString();
        final StringBuilder newDef = new StringBuilder();
        for (final String line : temp.split("\n"))  {
            newDef.append(line.trim()).append(' ');
        }

        Assert.assertEquals(newDef.toString().trim(), oldDef.trim());
    }
}
