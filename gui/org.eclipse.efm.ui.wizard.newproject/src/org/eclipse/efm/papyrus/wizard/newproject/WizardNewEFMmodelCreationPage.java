/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Erwan Mahe (CEA LIST) erwan.mahe@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.papyrus.wizard.newproject;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class WizardNewEFMmodelCreationPage extends WizardPage {
        private Text model_file_name;
        private Text root_node_name;
        private Composite container;

        public WizardNewEFMmodelCreationPage() {
        	super("WizardNewEFMmodelCreationPage");
            setTitle("Model Creation");
            setDescription("Please enter a name for the model file and for the model's root node.");
        }

        @Override
        public void createControl(Composite parent) {
            container = new Composite(parent, SWT.NONE);
            GridLayout layout = new GridLayout();
            container.setLayout(layout);
            layout.numColumns = 2;
            
            KeyListener completion_listener = new KeyListener() {

                @Override
                public void keyPressed(KeyEvent e) {
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    if (!model_file_name.getText().isEmpty() && !root_node_name.getText().isEmpty()) {
                    	setPageComplete(true);
                    }
                }

            };
                
            Label label_model_name = new Label(container, SWT.NONE);
            label_model_name.setText("Model file name :");

            model_file_name = new Text(container, SWT.BORDER | SWT.SINGLE);
            model_file_name.setText("");
            model_file_name.addKeyListener(completion_listener);
            
            Label label_node_name = new Label(container, SWT.NONE);
            label_node_name.setText("Root node name :");

            root_node_name = new Text(container, SWT.BORDER | SWT.SINGLE);
            root_node_name.setText("");
            root_node_name.addKeyListener(completion_listener);
            
            
            GridData gd = new GridData(GridData.FILL_HORIZONTAL);
            model_file_name.setLayoutData(gd);
            root_node_name.setLayoutData(gd);
            // required to avoid an error in the system
            setControl(container);
            setPageComplete(false);

        }

        public String getModelFileName() {
            return model_file_name.getText();
        }
        
        public String getRootNodeName() {
            return root_node_name.getText();
        }
}