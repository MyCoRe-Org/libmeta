/* 
 * This file is part of *** MyCoRe LibMeta ***
 * See https://github.com/MyCoRe-Org/libmeta/ for details.
 * 
 * MyCoRe LibMeta is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published 
 * by the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 *
 * MyCoRe LibMeta is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with MyCoRe LibMeta.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.mycore.libmeta.alto.model.description;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Information about a software application. Where applicable, the preferred
 * method for determining this information is by selecting Help -- About.
 * 
 * @author Robert Stephan
 * @version Alto 2.1
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "softwareCreator", "softwareName", "softwareVersion", "applicationDescription" })
public class ProcessingSoftware {

	/**
	 * The name of the organization or company that created the application.
	 */
	@XmlElement(name = "softwareCreator", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
	protected String softwareCreator;

	/**
	 * The name of the application.
	 */
	@XmlElement(name = "softwareName", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
	protected String softwareName;

	/**
	 * The version of the application.
	 */
	@XmlElement(name = "softwareVersion", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
	protected String softwareVersion;

	/**
	 * A description of any important characteristics of the application, especially
	 * for non-commercial applications. For example, if a non-commercial application
	 * is built using commercial components, e.g., an OCR engine SDK. Those
	 * components should be mentioned here.
	 */
	@XmlElement(name = "applicationDescription", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
	protected String applicationDescription;

	public String getSoftwareCreator() {
		return softwareCreator;
	}

	public void setSoftwareCreator(String softwareCreator) {
		this.softwareCreator = softwareCreator;
	}

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public String getSoftwareVersion() {
		return softwareVersion;
	}

	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}

	public String getApplicationDescription() {
		return applicationDescription;
	}

	public void setApplicationDescription(String applicationDescription) {
		this.applicationDescription = applicationDescription;
	}

	public static Builder builder() {
		return builder(new ProcessingSoftware());
	}

	public static Builder builder(ProcessingSoftware processingSoftware) {
		return new Builder(processingSoftware);
	}

	public static class Builder extends BuilderBase<ProcessingSoftware, Builder> {

		protected Builder(ProcessingSoftware processingSoftware) {
			super(processingSoftware);
		}

		public Builder softwareCreator(String softwareCreator) {
			_target().setSoftwareCreator(softwareCreator);
			return _self();
		}

		public Builder softwareName(String softwareName) {
			_target().setSoftwareName(softwareName);
			return _self();
		}

		public Builder softwareVersion(String softwareVersion) {
			_target().setSoftwareVersion(softwareVersion);
			return _self();
		}

		public Builder applicationDescription(String applicationDescription) {
			_target().setApplicationDescription(applicationDescription);
			return _self();
		}
	}
}
