/*
 * Copyright (C) The Spice Group. All rights reserved.
 *
 * This software is published under the terms of the Spice
 * Software License version 1.1, a copy of which has been included
 * with this distribution in the LICENSE.txt file.
 */
package org.realityforge.netserve.sockets.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import org.realityforge.netserve.sockets.ServerSocketFactory;

/**
 * Factory implementation for vanilla TCP sockets.
 *
 * @author <a href="mailto:peter at apache.org">Peter Donald</a>
 * @version $Revision: 1.1 $ $Date: 2003-04-23 01:32:18 $
 * @phoenix.component
 * @phoenix.service type="ServerSocketFactory"
 */
public class DefaultServerSocketFactory
    implements ServerSocketFactory
{
    /**
     * Creates a socket on specified port.
     *
     * @param port the port (0 indicates any available port)
     * @return the created ServerSocket
     * @throws IOException if unable to create socket
     */
    public ServerSocket createServerSocket( final int port )
        throws IOException
    {
        return new ServerSocket( port );
    }

    /**
     * Creates a socket on specified port with a specified backlog.
     *
     * @param port the port (0 indicates any available port)
     * @param backlog the backlog
     * @return the created ServerSocket
     * @throws IOException if unable to create socket
     */
    public ServerSocket createServerSocket( int port, int backlog )
        throws IOException
    {
        return new ServerSocket( port, backlog );
    }

    /**
     * Creates a socket on a particular network interface on specified port
     * with a specified backlog.
     *
     * @param port the port (0 indicates any available port)
     * @param backlog the backlog
     * @param address the network interface to bind to.
     * @return the created ServerSocket
     * @throws IOException if unable to create socket
     */
    public ServerSocket createServerSocket( int port, int backlog, InetAddress address )
        throws IOException
    {
        return new ServerSocket( port, backlog, address );
    }
}

