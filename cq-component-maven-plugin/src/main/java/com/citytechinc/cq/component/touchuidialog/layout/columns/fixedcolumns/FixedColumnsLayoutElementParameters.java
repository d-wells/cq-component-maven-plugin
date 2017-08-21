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
import com.citytechinc.cq.component.touchuidialog.TouchUIDialogType;
import com.citytechinc.cq.component.touchuidialog.container.Section;
import com.citytechinc.cq.component.touchuidialog.layout.LayoutElementParameters;
import org.codehaus.plexus.util.StringUtils;

public class FixedColumnsLayoutElementParameters extends LayoutElementParameters {

	private String title;
	private String path;
	private TouchUIDialogElement renderCondition;
	private boolean showOnCreate;
	private boolean hideOnEdit;
	private String orderBefore;

	@Override
	public String getResourceType() {
		if (StringUtils.isNotEmpty(path)) {
			return Section.INCLUDE_RESOURCE_TYPE;
		} else if(TouchUIDialogType.CORAL3.isOfType(getTouchUIDialogType())) {
			return FixedColumnsLayoutElement.RESOURCE_TYPE_CORAL3;
		}
		return FixedColumnsLayoutElement.RESOURCE_TYPE;
	}

	@Override
	public void setResourceType(String resourceType) {
		throw new UnsupportedOperationException("resource type is Static for Tabs Layout Element");
	}

	@Override
	public String getFieldName() {
		return this.fieldName;
	}

	@Override
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public TouchUIDialogElement getRenderCondition() {
		return renderCondition;
	}

	public void setRenderCondition(TouchUIDialogElement renderCondition) {
		this.renderCondition = renderCondition;
	}

	public boolean isShowOnCreate() {
		return showOnCreate;
	}

	public void setShowOnCreate(boolean showOnCreate) {
		this.showOnCreate = showOnCreate;
	}

	public boolean isHideOnEdit() {
		return hideOnEdit;
	}

	public void setHideOnEdit(boolean hideOnEdit) {
		this.hideOnEdit = hideOnEdit;
	}

	public String getOrderBefore() {
		return orderBefore;
	}

	public void setOrderBefore(String orderBefore) {
		this.orderBefore = orderBefore;
	}
}