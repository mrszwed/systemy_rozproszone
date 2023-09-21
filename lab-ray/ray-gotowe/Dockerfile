FROM python:3.10.9-slim

RUN pip install "ray[default]"
RUN pip install tensorflow
RUN pip install scikit-learn
ARG RAY_USE_MULTIPROCESSING_CPU_COUNT=1
WORKDIR /app
CMD ["bash", "-c", "ray start --head --num-cpus 1 --dashboard-host 0.0.0.0 --include-dashboard=true --block"]
