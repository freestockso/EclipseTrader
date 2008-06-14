/*
 * Copyright (c) 2004-2008 Marco Maccaferri and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Marco Maccaferri - initial API and implementation
 */

package org.eclipsetrader.ui.internal;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipsetrader.ui.UIConstants;

public class TraderPerspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		// Editors are not needed
		layout.setEditorAreaVisible(false);

		// Our editor area
		IFolderLayout editorsFolder = layout.createFolder("org.eclipsetrader.ui.editorss", IPageLayout.LEFT, (float) 100.0, layout.getEditorArea()); //$NON-NLS-1$
		editorsFolder.addPlaceholder("org.eclipsetrader.ui.views.watchlist:*");

        // Left.
        IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, (float) 0.20, UIConstants.EDITOR_AREA); //$NON-NLS-1$
        left.addView("org.eclipsetrader.ui.views.navigator"); //$NON-NLS-1$
        left.addPlaceholder("org.eclipsetrader.ui.views.repositories"); //$NON-NLS-1$

        // Bottom
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, (float) 0.75, UIConstants.EDITOR_AREA); //$NON-NLS-1$
		bottom.addView("org.eclipsetrader.ui.views.markets"); //$NON-NLS-1$

        // Add "new wizards".
		layout.addNewWizardShortcut("org.eclipsetrader.ui.wizards.new.security");//$NON-NLS-1$
        layout.addNewWizardShortcut("org.eclipsetrader.ui.wizards.new.watchList");//$NON-NLS-1$

        // Add "show views".
        layout.addShowViewShortcut("org.eclipsetrader.ui.views.navigator"); //$NON-NLS-1$
        layout.addShowViewShortcut("org.eclipsetrader.ui.views.markets"); //$NON-NLS-1$
        layout.addShowViewShortcut("org.eclipsetrader.ui.views.repositories"); //$NON-NLS-1$

        // Add default action sets
        layout.addActionSet("org.eclipsetrader.ui.launcher");
	}
}
