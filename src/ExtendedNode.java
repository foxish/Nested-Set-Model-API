import org.w3c.dom.Node;
public class ExtendedNode {
	private Node node;
	private int left;
	private int right;
	/**
	 * Container class for the extended node, containing left and right values
	 * Add more parameters as necessary
	 * @param node
	 * @param left
	 * @param right
	 */
	public ExtendedNode(Node node, int left, int right){
		this.node = node;
		this.left = left;
		this.right = right;
	}
	public Node getNode() {
		return node;
	}
	public int getLeft() {
		return left;
	}
	public int getRight() {
		return right;
	}
}
