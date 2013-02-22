Nested-Set-Model-API
==================== 

Java class to make it easy to generate nested set model left and right values from given xml. Very generic, should work with all well-formed XML. Uses org.w3c.dom for traversal in conjunction with Xpath

The nested set model makes it easy to store heirarchical data in a database. 
However, it needs that the pre-order traversal be made such that every node is visited twice and assigned "left" and "right values"

Details are over at http://en.wikipedia.org/wiki/Nested_set_model

Sample usage of this class:

    File xmlFile = new File("src/sampleHtml.xml"); //xml file
    XmlWalk xmw = new XmlWalk(xmlFile, new String[]{}); //pass empty string, for no exclusions (or null)
    result = xmw.getResult(); //fetch results
    for(ExtendedNode en : result){ //iterate through results
    	System.out.println(en.getNode().getNodeName() + " --> " + en.getLeft() + " : " + en.getRight());
    }

Similarly, it can be used with xml strings as input. It allows skipping certain tags, from the entire traversal itself.
They can be passed as a string array, in the constructor itself.

It retrieves results in an ArrayList of ExtendedNode objects. Further additions can be made to ExtendedNode, if necessary.

Try TestXmlWalk to get an idea:
##Input:


    <html>
    	<head>
       		<title>bux</title>
    	</head>
    	<body>
    		<div>
    			<div>1.1</div>
    			<div>1.2></div>
    		</div>
    		<div>2</div>
    	</body>
    </html>

##Output (no exlusion, pre-order):

<pre>
Node-name  Left   Right
html        1     16
head        2     5
title       3     4
body        6     15
div         7     12
div         8     9
div         10    11
div         13    14
</pre>


##Why this output:

                                       html (1,16)
                                        |
                                        |
                                  -------------
                                 |             |
                              head(2,5)     body(6,15)
                                 |             |
                             -----         ----------
                            |             |          |
                        title(3,4)    div(7,12)    div(13,14)
                                          |
                                      ---------
                                     |         |
                                  div(8,9)  div(10,11)



