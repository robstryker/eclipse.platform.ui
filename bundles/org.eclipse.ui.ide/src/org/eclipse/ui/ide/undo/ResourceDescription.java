/*******************************************************************************
 * Copyright (c) 2007, 2015 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package org.eclipse.ui.ide.undo;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.undo.snapshot.IResourceSnapshot;
import org.eclipse.core.resources.undo.snapshot.ResourceSnapshotFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * ResourceDescription is a lightweight description that describes the common
 * attributes of a resource to be created.
 *
 * This class is not intended to be extended by clients.
 *
 * @since 3.3
 * @deprecated Since 3.22, use {@link IResourceSnapshot} instead for most cases
 *
 */
@Deprecated
public abstract class ResourceDescription implements IResourceSnapshot {

	/**
	 * Create a resource description given the specified resource. The resource is
	 * assumed to exist.
	 *
	 * @param resource the resource from which a description should be created
	 * @return the resource description
	 * @deprecated Since 3.22, use
	 *             {@link ResourceSnapshotFactory#fromResource(IResource)} instead
	 */
	@Deprecated
	public static ResourceDescription fromResource(IResource resource) {
		IResourceSnapshot delegate = ResourceSnapshotFactory.fromResource(resource);
		return new ResourceDescription() {

			@Override
			public IResource createResourceHandle() {
				return delegate.createResourceHandle();
			}

			@Override
			public String getName() {
				return delegate.getName();
			}

			@Override
			public IResource createResource(IProgressMonitor monitor) throws CoreException {
				return delegate.createResource(monitor);
			}

			@Override
			public void createExistentResourceFromHandle(IResource resource1, IProgressMonitor monitor)
					throws CoreException {
				delegate.createExistentResourceFromHandle(resource1, monitor);
			}

			@Override
			public boolean isValid() {
				return delegate.isValid();
			}

			@Override
			public void recordStateFromHistory(IResource resource1, IProgressMonitor monitor) throws CoreException {
				delegate.recordStateFromHistory(resource1, monitor);
			}

			@Override
			public boolean verifyExistence(boolean checkMembers) {
				return delegate.verifyExistence(checkMembers);
			}
		};
	}
}
