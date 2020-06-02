FROM rubensa/ubuntu-tini-dev

# Change docker socket owner
RUN printf "\nsudo chmod a+rw /var/run/docker.sock\n" >> /home/${USER_NAME}/.bashrc

# Keep container running (for use in VSCode)
CMD [ "tail", "-f", "/dev/null" ]

# Allow vscode-server cache
RUN mkdir -p /home/${USER_NAME}/.vscode-server

# Allow shared Maven config
RUN mkdir /home/${USER_NAME}/.m2/
