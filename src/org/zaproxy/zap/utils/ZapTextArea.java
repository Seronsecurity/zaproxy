/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zaproxy.zap.utils;

import javax.swing.JTextArea;
import javax.swing.text.Document;

import org.zaproxy.zap.utils.ZapTextComponentUndoManager.UndoManagerPolicy;

/**
 * <code>ZapTextArea</code> is a <code>JTextArea</code> with
 * <code>UndoableEdits</code>.
 * 
 * <p>
 * It is responsibility of the owner of the <code>ZapTextArea</code> to discard
 * all undoable edits when they are not needed.
 * </p>
 * 
 * <p>
 * If you do not need undoable edits consider using a <code>JTextArea</code>
 * instead.
 * </p>
 * 
 * @see #discardAllEdits
 * @see ZapTextComponentUndoManager
 */
public class ZapTextArea extends JTextArea {

	private static final long serialVersionUID = -5473367713363097247L;

	private ZapTextComponentUndoManager undoManager;

	/**
	 * @see JTextArea#JTextArea()
	 */
	public ZapTextArea() {
		this(null, null, 0, 0);
	}

	/**
	 * @see JTextArea#JTextArea(Document)
	 */
	public ZapTextArea(Document doc) {
		this(doc, null, 0, 0);
	}

	/**
	 * @see JTextArea#JTextArea(String)
	 */
	public ZapTextArea(String text) {
		this(null, text, 0, 0);
	}

	/**
	 * @see JTextArea#JTextArea(int, int)
	 */
	public ZapTextArea(int rows, int columns) {
		this(null, null, rows, columns);
	}

	/**
	 * @see JTextArea#JTextArea(String, int, int)
	 */
	public ZapTextArea(String text, int rows, int columns) {
		this(null, text, rows, columns);
	}

	/**
	 * @see JTextArea#JTextArea(Document, String, int, int)
	 */
	public ZapTextArea(Document doc, String text, int rows, int columns) {
		super(doc, text, rows, columns);

		undoManager = new ZapTextComponentUndoManager(this);
	}

	/**
	 * Discards all undoable edits.
	 * 
	 * @see ZapTextComponentUndoManager#discardAllEdits()
	 */
	public void discardAllEdits() {
		undoManager.discardAllEdits();
	}

	/**
	 * Sets the maximum number of undoable edits this <code>ZapTextArea</code>
	 * can hold.
	 * 
	 * @param limit
	 *            the new limit
	 * 
	 * @see ZapTextComponentUndoManager#setLimit(int)
	 */
	public void setEditsLimit(int limit) {
		undoManager.setLimit(limit);
	}

	/**
	 * Sets the policy of the undoable edits of this <code>ZapTextArea</code>.
	 * 
	 * @param policy
	 *            the new policy
	 * 
	 * @see ZapTextComponentUndoManager#setUndoManagerPolicy(UndoManagerPolicy)
	 */
	public void setUndoManagerPolicy(UndoManagerPolicy policy) {
		undoManager.setUndoManagerPolicy(policy);
	}

}
