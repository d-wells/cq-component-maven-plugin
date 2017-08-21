/**
 *    Copyright 2017 ICF Olson
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.citytechinc.cq.component.touchuidialog.layout.columns.fixedcolumns;

import com.citytechinc.cq.component.touchuidialog.TouchUIDialogElement;
import com.citytechinc.cq.component.touchuidialog.container.items.Items;
import com.citytechinc.cq.component.touchuidialog.container.items.ItemsParameters;
import com.citytechinc.cq.component.touchuidialog.layout.Layout;
import com.citytechinc.cq.component.touchuidialog.layout.columns.Column;
import com.citytechinc.cq.component.touchuidialog.layout.columns.ColumnParameters;
import com.citytechinc.cq.component.touchuidialog.layout.maker.AbstractLayoutMaker;
import com.citytechinc.cq.component.touchuidialog.layout.maker.LayoutMakerParameters;
import com.citytechinc.cq.component.touchuidialog.layout.maker.exceptions.LayoutMakerException;
import com.citytechinc.cq.component.touchuidialog.util.TouchUIDialogUtil;
import com.citytechinc.cq.component.touchuidialog.widget.factory.TouchUIWidgetFactory;
import com.citytechinc.cq.component.touchuidialog.widget.maker.TouchUIWidgetMakerParameters;

import java.util.List;

public class FixedColumnsLayoutCoral3Maker extends AbstractLayoutMaker {

	public FixedColumnsLayoutCoral3Maker(LayoutMakerParameters parameters) {
		super(parameters);
	}

	@Override
	public Layout make() throws LayoutMakerException {
		// Create layout element and add items to it
		FixedColumnsLayoutElementParameters fixedColumnsLayoutElementParameters = new FixedColumnsLayoutElementParameters();
		fixedColumnsLayoutElementParameters.setContainedElements(TouchUIDialogUtil.createContainedElements(makeItems()));
		fixedColumnsLayoutElementParameters.setTouchUIDialogType(parameters.getTouchUIDialogType());
		FixedColumnsLayoutElement layoutElement = new FixedColumnsLayoutElement(fixedColumnsLayoutElementParameters);
		layoutElement.setFieldName("fixedColumns");

		// Create items element and add layout element to it
		ItemsParameters itemsParameters = new ItemsParameters();
		itemsParameters.setFieldName("items");
		itemsParameters.setContainedElements(TouchUIDialogUtil.createContainedElements(layoutElement));
		Items items = new Items(itemsParameters);

		// Create content element and add items element to it
		FixedColumnsLayoutParameters layoutParameters = new FixedColumnsLayoutParameters();
		layoutParameters.setContainedElements(TouchUIDialogUtil.createContainedElements(items));
		layoutParameters.setTouchUIDialogType(parameters.getTouchUIDialogType());
		layoutParameters.setFieldName("content");

		return new FixedColumnsLayout(layoutParameters);
	}

	protected Items makeItems() throws LayoutMakerException {
		ColumnParameters columnParameters = new ColumnParameters();
		columnParameters.setTouchUIDialogType(parameters.getTouchUIDialogType());
		columnParameters.setFieldName("column");

		try {
			// Populate the column content
			List<TouchUIWidgetMakerParameters> widgetMakerParameters =
					TouchUIDialogUtil.getWidgetMakerParametersForComponentClass(
							parameters.getComponentClass(),
							parameters.getClassLoader(),
							parameters.getClassPool(),
							parameters.getWidgetRegistry(),
							parameters.getTouchUIDialogType());

			for (TouchUIWidgetMakerParameters currentWidgetMakerParameters : widgetMakerParameters) {
				currentWidgetMakerParameters.setTouchUIDialogType(parameters.getTouchUIDialogType());
				TouchUIDialogElement currentElement = TouchUIWidgetFactory.make(currentWidgetMakerParameters, -1);
				if (currentElement != null) {
					currentElement.setRanking(currentWidgetMakerParameters.getDialogFieldConfig().getRanking());
					columnParameters.addItem(currentElement);
				}
			}
		} catch (Exception e) {
			throw new LayoutMakerException("Exception encountered while constructing widgets for layout", e);
		}

		// Create and add the column section
		Column column = new Column(columnParameters);
		ItemsParameters itemsParameters = new ItemsParameters();
		itemsParameters.setFieldName("items");
		itemsParameters.setContainedElements(TouchUIDialogUtil.createContainedElements(column));

		return new Items(itemsParameters);
	}
}