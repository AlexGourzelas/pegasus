/*
 * This file or a portion of this file is licensed under the terms of
 * the Globus Toolkit Public License, found in file GTPL, or at
 * http://www.globus.org/toolkit/download/license.html. This notice must
 * appear in redistributions of this file, with or without modification.
 *
 * Redistributions of this Software, with or without modification, must
 * reproduce the GTPL in: (1) the Software, or (2) the Documentation or
 * some other similar material which is provided with the Software (if
 * any).
 *
 * Copyright 1999-2004 University of Chicago and The University of
 * Southern California. All rights reserved.
 */

package org.griphyn.vdl.parser;

import org.griphyn.vdl.classes.*;
import org.griphyn.vdl.util.Logging;
import org.xml.sax.*;

/**
 * This class is the error handler for the parser. It defines how to
 * handle three different kinds of parsing exceptions: warning, error,
 * and fatal error. Here we simply print the error message and the location
 * where the error happend.
 *
 * @author Jens-S. Vöckler
 * @author Yong Zhao
 * @version $Revision$
 */

public class VDLErrorHandler implements ErrorHandler
{
  /**
   * Receive notification of a warning.<p>
   *
   * SAX parsers will use this method to report conditions that are not
   * errors or fatal errors as defined by the XML 1.0 recommendation.
   * The default behaviour is to take no action.<p>
   *
   * The SAX parser must continue to provide normal parsing events after
   * invoking this method: it should still be possible for the
   * application to process the document through to the end.
   *
   * @param e is a warning generated by the SAX parser.
   * @see org.xml.sax.ErrorHandler#warning( org.xml.sax.SAXParseException )
   */
  public void warning ( SAXParseException e )
    throws SAXException
  {
    Logging.instance().log( "app", 1, "*** parser warning *** " +
			    " Line: " + e.getLineNumber() + "\n" +	
			    "[" + e + "]\n");
    //throw new SAXException("Warning occurred");
  }
  
  /**
   * Receive notification of a recoverable error.<p>
   *
   * This corresponds to the definition of "error" in section 1.2 of the
   * W3C XML 1.0 Recommendation. For example, a validating parser would
   * use this callback to report the violation of a validity constraint.
   * The default behaviour is to take no action.<p>
   *
   * The SAX parser must continue to provide normal parsing events after
   * invoking this method: it should still be possible for the
   * application to process the document through to the end. If the
   * application cannot do so, then the parser should report a fatal
   * error even if the XML 1.0 recommendation does not require it to do
   * so.
   *
   * @param e is an error generated by the SAX parser.
   * @see org.xml.sax.ErrorHandler#error( org.xml.sax.SAXParseException )
   */
  public void error( SAXParseException e )
    throws SAXException
  {
    Logging.instance().log( "app", 0, "*** parser error *** " +
			    " Line: " + e.getLineNumber() + "\n" +	
			    "[" + e + "]\n");
    //throw new SAXException("Error occurred");
  }

  /**
   * Receive notification of a non-recoverable error.<p>
   *
   * This corresponds to the definition of "fatal error" in section 1.2
   * of the W3C XML 1.0 Recommendation. For example, a parser would use
   * this callback to report the violation of a well-formedness
   * constraint.<p>
   *
   * The application must assume that the document is unusable after the
   * parser has invoked this method, and should continue (if at all)
   * only for the sake of collecting addition error messages: in fact,
   * SAX parsers are free to stop reporting any other events once this
   * method has been invoked.
   *
   * @param e is a fatal error generated by the SAX parser.
   * @see org.xml.sax.ErrorHandler#fatalError( org.xml.sax.SAXParseException )
   */
  public void fatalError( SAXParseException e )
    throws SAXException
  {
    Logging.instance().log( "default", 0, "!!! fatal error !!! " +
			    " Line: " + e.getLineNumber() + "\n" +	
			    "[" + e + "]\n");
    //throw new SAXException("Fatal Error occurred");
  }
};